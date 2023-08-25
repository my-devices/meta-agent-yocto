# macchina.io REMOTE Device Agent Yocto Package

Yocto layer meta data for macchina.io REMOTE Device Agent
([WebTunnelAgent](https://github.com/my-devices/sdk/blob/master/WebTunnel/WebTunnelAgent)).


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


## Building

Add `/path/to/meta-agent-yocto` to `BBLAYERS` in your `build/conf/bblayers.conf` file.

In your Yocto build environment, you can then run:

```
$ bitbake macchina-remote-agent
```

to build the `macchina-remote-agent` package.

To install the package, add:

```
CORE_IMAGE_EXTRA_INSTALL += "macchina-remote-agent"
```

to your `build/conf/local.conf` file.

