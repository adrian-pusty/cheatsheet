# config
git config --global user.name "Global Name"
git config --global user.email "global-email@abc.def"
git config user.name "Repo Specific Name"
git config user.email "repospecific-email@abc.def"

git config -l # list all

# ...
git remote rm {remote-name} # remove remote

git reset HEAD~ # Delete last commit locally
git reset --hard HEAD~1 # https://stackoverflow.com/a/1338744/15493760

git checkout -b branch_name # Create new branch locally

# Change last commit message
git commit --amend
git commit --amend -m "updated message"

git rebase -i HEAD~n # Interactive rebase of n last commits locally

git branch -m oldname newname # rename branch