DESCRIPTION = "macchina.io REMOTE Device Agent"

SECTION = "network"
DEPENDS = "openssl"
RDEPENDS_${PN} += "lsbinitscripts ca-certificates"
LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4267f48fc738f50380cbeeb76f95cebc"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/my-devices/sdk.git;protocol=https;branch=main \
	file://cmake-version.patch \
	file://WebTunnelAgent \
	file://WebTunnelAgent.service \
	file://WebTunnelAgent.properties"

S = "${WORKDIR}/git"

inherit cmake update-rc.d systemd

EXTRA_OECMAKE = "-DENABLE_WEBTUNNELCLIENT=OFF -DENABLE_WEBTUNNELSSH=OFF -DENABLE_WEBTUNNELSCP=OFF -DENABLE_WEBTUNNELSFTP=OFF -DENABLE_WEBTUNNELVNC=OFF -DENABLE_WEBTUNNELRDP=OFF"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME = "WebTunnelAgent"
INITSCRIPT_PARAMS = "defaults 80"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "WebTunnelAgent.service"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d ${D}${systemd_system_unitdir} ${D}${sysconfdir}
	install -m 0755 ${WORKDIR}/WebTunnelAgent ${D}${sysconfdir}/init.d
	install -m 0644 ${WORKDIR}/WebTunnelAgent.service ${D}${systemd_system_unitdir}
	sed -i -e 's,@BINDIR@,${bindir},g' \
		-e 's,@SYSCONFDIR@,${sysconfdir},g' \
		-e 's,@LOCALSTATEDIR@,${localstatedir},g' \
		${D}${systemd_system_unitdir}/WebTunnelAgent.service
	install -m 0644 ${WORKDIR}/WebTunnelAgent.properties ${D}${sysconfdir}
}

CONFFILES_${PN} = "${sysconfdir}/WebTunnelAgent.properties"
