SUMMARY = "Qt CEC plugin"
LICENSE = "LGPL-2.1"
DEPENDS = "qtbase libcec glib-2.0"

LIC_FILES_CHKSUM = "file://LICENSE.GPL2;md5=b234ee4d69f5fce4486a80fdaf4a4263"
SRC_URI = "git://github.com/lkmikkel/QtCECPlugin.git;protocol=http"
SRCREV = "715232ec1c8f14861889bf04fa9061c6cb808e40"

S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

RDEPENDS_${PN} += "qtbase-plugins libcec"
