FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://0005-service.patch"

PACKAGECONFIG = "wispr \
                   ${@bb.utils.filter('DISTRO_FEATURES', '3g systemd', d)} \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'iwd', '', d)} \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'bluez', '', d)} \
		   iptables \
"

PACKAGECONFIG[iwd] = "--enable-iwd,--disable-iwd,iwd,iwd"
