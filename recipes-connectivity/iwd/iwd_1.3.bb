DESCRIPTION = "Wireless daemon for Linux"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=fb504b67c50331fc78734fed90fb0e09"

inherit autotools pkgconfig systemd

DEPENDS = "ell readline dbus"

SRC_URI = "git://git.kernel.org/pub/scm/network/wireless/iwd.git"
SRCREV = "7e393663e7f266c2a6c42479c37d22bc5a5b3a45"
S = "${WORKDIR}/git"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)}"
PACKAGECONFIG[wired] = "--enable-wired,--disable-wired"
PACKAGECONFIG[ofono] = "--enable-ofono,--disable-ofono"
PACKAGECONFIG[systemd] = "--with-systemd-unitdir=${systemd_system_unitdir},--disable-systemd-service,systemd"

EXTRA_OECONF += "--enable-external-ell --disable-manual-pages"

do_configure_prepend () {
    mkdir -p ${S}/build-aux
}

do_install_append() {
    mkdir --parents ${D}${docdir}/${BPN}
    install -m 0644 ${S}/doc/*.txt ${D}${docdir}/${BPN}
    install -d ${D}/var/lib/iwd
}

FILES_${PN} += "${datadir}/dbus-1 /lib/systemd/"
FILES_${PN}-dev += "${libdir}/modules-load.d"

SYSTEMD_SERVICE_${PN} = "iwd.service ${@bb.utils.contains('PACKAGECONFIG', 'wired', 'ead.service', '', d)}"

RRECOMMENDS_${PN} = "\
    kernel-module-pkcs7-message \
    kernel-module-pkcs8-key-parser \
    kernel-module-x509-key-parser \
"

