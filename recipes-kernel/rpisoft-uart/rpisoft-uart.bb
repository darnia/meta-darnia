FILESEXTRAPATHS_prepend = "${THISDIR}/files:"
SUMMARY = "software-based serial port/UART using any GPIO pin"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

inherit module

SRC_URI = " \
	git://github.com/adrianomarto/soft_uart.git;protocol=https \
	file://0001-makefile.patch \
"
SRCREV = "5fd78faad78d3c3e2b7bafac9b98ef3552432800"

S = "${WORKDIR}/git"
