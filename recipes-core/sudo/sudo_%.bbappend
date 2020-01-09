SUMMARY = "Replacement sudoers recipe"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += " file://sudoers"

do_install_append() {
        install -m 0440 ${WORKDIR}/sudoers ${D}${sysconfdir}/sudoers
}
