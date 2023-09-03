#!/bin/sh

export netns_name=c1
export veth_name=veth1
export veth_br_name=veth1-br0
export netns_IP=10.0.1.1
export netns_MAC=10:00:00:00:01:01

### LANケーブル作成 ###
ip link add name ${veth_name} type veth peer name ${veth_br_name}
ip link set ${veth_name} netns ${netns_name}

ip netns exec ${netns_name} ip addr add ${netns_IP}/24 dev ${veth_name}
ip netns exec ${netns_name} ip link set dev ${veth_name} address ${netns_MAC}
ip netns exec ${netns_name} ip link set dev ${veth_name} up

ip link set ${veth_br_name} master br0
ip link set ${veth_br_name} up

ip netns exec ${netns_name} ip route add 10.0.0.0/16 via ${netns_IP} dev veth1