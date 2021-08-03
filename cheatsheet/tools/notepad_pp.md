### How to break lines at a specific character in Notepad++?
(I want the lines break at ], characters)
Click Ctrl + h or Search -> Replace on the top menu
Under the Search Mode group, select Regular expression
In the Find what text field, type ],\s*
In the Replace with text field, type ],\n
Click Replace All
~https://stackoverflow.com/questions/10668044/how-to-break-lines-at-a-specific-character-in-notepad/10668109#10668109