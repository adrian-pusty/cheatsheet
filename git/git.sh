# config
git config --global user.name "Global Name"
git config --global user.email "global-email@abc.def"
git config user.name "Repo Specific Name"
git config user.email "repospecific-email@abc.def"

git config -l # list all

# ...
git remote rm {remote-name} # remove remote
git remote set-url origin {new-url}

git reset HEAD~ # Delete last commit locally
git reset --hard HEAD~1 # https://stackoverflow.com/a/1338744/15493760

git checkout -b branch_name # Create new branch locally

git commit --amend # Change last commit message
git commit --amend -m "updated message"

git rebase -i HEAD~n # Interactive rebase of n last commits locally

git merge origin/remote_branch_name

git branch -m oldname newname # rename branch
git branch -d branch_name # Delete a branch.
git branch -D branch_name # (force) Delete a branch.

git stash push -m "name"
git stash list
git stash apply 'stash@{n}' #apply and keep
git stash pop 'stash@{n}'   #apply and remove

git log --oneline # one commit per line
git shortlog -ns # number of commits, user

git add --chmod=+x # make executable