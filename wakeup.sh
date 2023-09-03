#!/bin/sh

### 自分のIPアドレスを取得 ###
export VM_IP=`ip addr show enp0s8 | grep -o 'inet [0-9]\+\.[0-9]\+\.[0-9]\+\.[0-9]\+' | grep -o [0-9].*`

### ns 作成 ###
ip --all netns delete 
ip link del br0
ip link del vxlan0
ip netns add c1
ip netns add c2

### bridge 作成 ###
ip link add dev br0 type bridge
ip addr add dev br0 ${br0_IP}/16
ip link set br0 up 

### vxlan作成 ###
ip link add dev vxlan0 type vxlan id 42 group 239.1.1.1 dev enp0s8 dstport 4789
ip link set vxlan0 master br0
ip link set vxlan0 up