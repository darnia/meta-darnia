SUMMARY = "DPS Power Supply console image"
LICENSE = "GPLv2"

IMAGE_FSTYPES = "wic wic.bmap"

inherit image 

DEFAULT_TIMEZONE = "UTC"

PACKAGE_CLASSES = "package_ipk"
PACKAGE_EXCLUDE = "udev-hwdb systemd-hwdb"

DEPENDS_append_rpi = " bcm2835-bootfiles"
DEPENDS_append = " u-boot-opi"

CORE_OS = " \
    packagegroup-core-boot \
    kernel-modules \
    openssh openssh-keygen openssh-sftp-server \
    tzdata-core \
    sudo \
"

WIFI_SUPPORT = " \
    iw \
    iwd \
    wireless-regdb-static \
"

BLUETOOTH_SUPPORT = " \
    bluez5 \
"

CONN_PKGS = " \
    iptables \
    avahi-daemon \
    connman connman-client \
    connman-conf \
"

TOOLS_PKGS = " \
    bzip2 \
    dosfstools \
    ethtool \
    findutils \
    grep \
    i2c-tools \
    iperf3 \
    iproute2 \
    iptables \
    less \
    lsof \
    mtd-utils \
    nmap \
    powertop \
    procps \
    sysfsutils \
    systemd-analyze \
    tcpdump \
    unzip \
    usbutils \
    util-linux \
    wget \
    zip \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${CONN_PKGS} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', '${BLUETOOTH_SUPPORT}', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', '${WIFI_SUPPORT}', '', d)} \
"
#    ${TOOLS_PKGS} 

IMAGE_INSTALL_rpi += " \
    udev-rules-rpi \
    rng-tools \
    linux-firmware-rpidistro-bcm43430 \
    linux-firmware-rpidistro-bcm43455 \
    bluez-firmware-rpidistro-bcm43430a1-hcd \
    bluez-firmware-rpidistro-bcm4345c0-hcd \
"

export IMAGE_BASENAME = "basic-image"
