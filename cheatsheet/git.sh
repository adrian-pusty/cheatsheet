git reset HEAD~ # Delete last commit locally

git checkout -b branch_name # Create new branch locally

# Change last commit message
git commit --amend
git commit --amend -m "updated message"

git rebase -i HEAD~n # Interactive rebase of n last commits locally
