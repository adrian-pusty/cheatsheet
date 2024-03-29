lsb_release -a # LSB (Linux Standard Base) and Distribution information.

mkdir -p 	# No error if existing, make parent directories as needed
top -c | grep 12345 # PID instead of 12345

ls -1 .		# Listing files in a single column
ls -lh    # -h, --human-readable # print sizes like 1K 234M 2G etc.

du -sm *  # ~howtogeek.com/168135/list-files-and-directories-by-size-on-linux/
du -sh abc* | sort -rh # sort by size

cat file1 file2 file3 >> output # merging file1, file2 and file3 to output file

find . -name '*java' -mtime +10 -newer App.java

echo $((0xF)) # Prints 15

echo "cd ~/path/to/directory" >> ~/.bashrc

# creating an alias
vim ~/.bash_aliases # add line: alias name_of_alias='some command -option'
source ~/.bashrc

grep -rnw '/path/to/somewhere/' -e 'pattern' # https://stackoverflow.com/questions/16956810/how-do-i-find-all-files-containing-specific-text-on-linux
grep -e "keep lines" -e "containing" -e "these character sequences" input.csv > output.csv # 'grep -v -e ...' to select non-matching lines

# shutdown / reboot
sudo poweroff
sudo reboot

tar -xvjf file.tar.bz2  # extract bz2