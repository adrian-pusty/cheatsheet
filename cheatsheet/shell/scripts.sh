xdg-open # opens a file or URL in the user's preferred application
command1 & command2 & command3 # https://askubuntu.com/questions/990423/how-can-i-run-multiple-commands-which-have-in-one-command-line

#for loop
for x in a b c d e f; do
    echo letter:${x}
done

# replace spaces in file names in provided path # https://stackoverflow.com/a/18213120/15493760, https://stackoverflow.com/a/5928254/15493760
for file in /some/path/*
do
        mv "$file" "${file// /_}"
done

# for loop + if statement
END=99
for ((i=1;i<=END;i++)); do
    if (($i%2 == 1))
    then
        echo $i;
    fi
done