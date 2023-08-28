# macchina.io REMOTE Device Agent Yocto Layer

Yocto layer meta data for macchina.io REMOTE Device Agent
([WebTunnelAgent](https://github.com/my-devices/sdk/blob/master/WebTunnel/WebTunnelAgent)).

The layer has been tested with Yocto Kirkstone and `core-image-sato` running in QEMU.

## About macchina.io REMOTE

[macchina.io REMOTE](https://macchina.io/remote) provides secure remote access to connected devices
via HTTP or other TCP-based protocols and applications such as secure shell (SSH) or
Virtual Network Computing (VNC). With macchina.io REMOTE, any network-connected device
running the macchina.io REMOTE Device Agent or this Gateway program can be securely accessed remotely over the
internet from browsers, mobile apps, desktop, server or cloud applications.

This even works if the device is behind a NAT router, firewall or proxy server.
The device becomes just another host on the internet, addressable via its own URL and
protected by the macchina.io REMOTE server against unauthorized or malicious access.
macchina.io REMOTE is a great solution for secure remote support and maintenance,
as well as for providing secure remote access to devices for end-users via web or
mobile apps.


## About this Repository

This repository contains a Yocto layer for building the macchina.io REMOTE Device Agent
as a Yocto package.
The package contains the `WebTunnelAgent` executable, a default configuration file
(`/etc/WebTunnelAgent.properties`) and an `init.d` script and `systemd` service file.

NOTE: The `webtunnel.domain` in the default configuration file is set to an all zero UUID,
so the agent won't be able to connect to the server. The domain must be set to
to a valid value for the agent to successfully connect.


## Building and Installing

Add `/path/to/meta-agent-yocto` to `BBLAYERS` in your `build/conf/bblayers.conf` file.

In your Yocto build environment, you can then run:

```
$ bitbake macchina-remote-agent
```

to build the `macchina-remote-agent` package.

To install the package in the image, add:

```
CORE_IMAGE_EXTRA_INSTALL += "macchina-remote-agent"
```

to your `build/conf/local.conf` file and rebuild the image.

Alternatively, the built package can also be manually installed on the target
using the package manager (e.g., `rpm` or `opkg`).

