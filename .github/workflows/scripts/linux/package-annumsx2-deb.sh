#!/usr/bin/env bash
set -euo pipefail
ROOT="${1:-$(pwd)}"; BUILD="${2:-$ROOT/build}"; OUT="${3:-$ROOT/ci-artifacts}"; VERSION="${VERSION:-0.1.2}"
PKG="$ROOT/build/annumsx2-deb"; rm -rf "$PKG"
mkdir -p "$PKG/DEBIAN" "$PKG/usr/bin" "$PKG/usr/share/applications" "$PKG/usr/share/icons/hicolor/256x256/apps" "$PKG/usr/share/doc/annumsx2"
BIN="$(find "$BUILD" -type f -name armsx2-qt -perm -111 | head -1)"; test -n "$BIN"
install -m755 "$BIN" "$PKG/usr/bin/annumsx2"
cat > "$PKG/usr/share/applications/annumsx2.desktop" <<'EOF'
[Desktop Entry]
Version=1.0
Terminal=false
Type=Application
Name=ANNUMSX2
StartupWMClass=ARMSX2
GenericName=PlayStation 2 Emulator
Comment=PlayStation 2 emulator based on ARMSX2 and PCSX2
Exec=annumsx2
Icon=annumsx2
Keywords=game;emulator;playstation;ps2;
Categories=Game;Emulator;
EOF
install -m644 "$ROOT/bin/resources/icons/AppIconLarge.png" "$PKG/usr/share/icons/hicolor/256x256/apps/annumsx2.png"
install -m644 "$ROOT/COPYING.GPLv3" "$PKG/usr/share/doc/annumsx2/COPYING.GPLv3"
test -f "$ROOT/bin/docs/ThirdPartyLicenses.html" && install -m644 "$ROOT/bin/docs/ThirdPartyLicenses.html" "$PKG/usr/share/doc/annumsx2/ThirdPartyLicenses.html"
cat > "$PKG/DEBIAN/control" <<EOF
Package: annumsx2
Version: $VERSION
Section: games
Priority: optional
Architecture: arm64
Maintainer: ANNUMSX2 Project
Description: ANNUMSX2 PlayStation 2 emulator for ARM64 Linux
 ANNUMSX2 is an ARM64-focused fork built on ARMSX2 and PCSX2.
EOF
mkdir -p "$OUT"; dpkg-deb --build --root-owner-group "$PKG" "$OUT/ANNUMSX2_${VERSION}_arm64.deb"
