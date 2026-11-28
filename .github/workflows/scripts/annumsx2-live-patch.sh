#!/usr/bin/env bash
set -euo pipefail

EXPECTED_REPO="ANNIX-AMMU/ANNUMSX2"
EXPECTED_BRANCH="enumsx2-a67l-blu-optimizations"

REPO="${GITHUB_REPOSITORY:-}"
BRANCH="${GITHUB_REF_NAME:-$(git branch --show-current 2>/dev/null || true)}"

if [ -n "$REPO" ] && [ "$REPO" != "$EXPECTED_REPO" ]; then
  echo "REFUSING: this patch is for $EXPECTED_REPO, not $REPO" >&2
  exit 2
fi

if [ "$BRANCH" != "$EXPECTED_BRANCH" ]; then
  echo "REFUSING: expected branch $EXPECTED_BRANCH, got $BRANCH" >&2
  exit 3
fi

test -f platforms/android/app/src/main/res/values/strings.xml
test -f COPYING.GPLv3

# Visible Android branding only. Internal upstream namespaces stay intact.
python3 - <<'PY'
from pathlib import Path
p=Path("platforms/android/app/src/main/res/values/strings.xml")
s=p.read_text()
s=s.replace('<string name="app_name">ARMSX2</string>',
            '<string name="app_name">ANNUMSX2</string>')
s=s.replace('<string name="app_name_nightly">ARMSX2 Nightly</string>',
            '<string name="app_name_nightly">ANNUMSX2 Nightly</string>')
p.write_text(s)
PY

# ANNUMSX2 marker used by CI/release scripts.
cat > ANNUMSX2_BUILD_IDENTITY.txt <<EOF
Project=ANNUMSX2
Repository=$EXPECTED_REPO
Branch=$EXPECTED_BRANCH
Upstream=ARMSX2/ARMSX2
EOF

echo "ANNUMSX2 live patch applied successfully."
echo "Upstream ARMSX2 repository was not modified."
