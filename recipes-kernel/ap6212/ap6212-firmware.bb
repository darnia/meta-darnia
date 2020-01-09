SUMMARY = "Broadcom WiFi AP6212 Firmware files for use with Linux kernel"
SECTION = "kernel"

LICENSE = "CLOSED"

SRCREV = "6dee7aabad92112e548b551c5acb9611d15e5b33"
SRC_URI = "git://github.com/BPI-SINOVOIP/BPI_WiFi_Firmware.git"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    install -d ${D}${nonarch_base_libdir}/firmware/brcm
    install -m 644 ${S}/ap6212/nvram_ap6212.txt ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio.txt
    install -m 644 ${S}/ap6212/fw_bcm43438a1.bin ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio.bin
    install -m 644 ${S}/ap6212/bcm43438a1.hcd ${D}${nonarch_base_libdir}/firmware/brcm/bcm43438a1.hcd
}

FILES_${PN} = "${nonarch_base_libdir}"
