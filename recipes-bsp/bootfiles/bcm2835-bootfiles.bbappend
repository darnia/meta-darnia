RPIFW_DATE = "20191122"
SRCREV = "204245361ea7b903494de666c4028dd7f21ee56e"

LIC_FILES_CHKSUM = "file://LICENCE.broadcom;md5=c403841ff2837657b2ed8e5bb474ac8d"
SRC_URI[md5sum] = "9a66d949db6f11ae09f1f1cb57db91e9"
SRC_URI[sha256sum] = "43f349627d1adb65099585111fbbdbe7ccf1dff7daba3943034657dd26f33fd6"
RPIFW_SRC_URI = "https://codeload.github.com/raspberrypi/firmware/tar.gz/${SRCREV}"
RPIFW_S = "${WORKDIR}/firmware-${SRCREV}"

do_unpack() {
    tar -C ${WORKDIR} -xzf ${DL_DIR}/${SRCREV}
}
