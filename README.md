# AntiPortal

This plugin has 2 commands, /enableportals and /disable portals.
If portals are disabled, the `PlayerPortalEvent` is simply canceled. If they are enabled with the command, then it will not be canceled.

I personally wanted to allow End Gateways, but if you do not want to, then simply remove the if statement at line 43 and put the contents in the `if (portalUsageEnabled)` statement.

This plugin is far from perfect, so if you are actively using it and are annoyed with a bug, open an issue and I will resolve it :)
