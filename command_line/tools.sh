# Documents
mutool convert -o output_file.txt input_file.epub # https://mupdf.com/

## PDF
pdftk input_file.pdf cat 111-222 output output_file.pdf # Extract pages 111-222 from input_file.pdf to output_file.pdf

pdftk input_1.pdf input_2.pdf cat output output.pdf # Merge multiple pdfs
pdfunite input_1.pdf input_2.pdf output.pdf # Merge multiple pdfs # worked a bit faster than pdftk (see above) for me

# Images
convert -resize 75% input_file_name output_file_name  # ImageMagick # resize picture
convert -flop input_file_name output_file_name # Horizontal mirroring
convert in.png -resize 100x100 -gravity center -background "rgb(255,255,255)" -extent 200x200 out.png # add white padding to png

# Audio / Video
ffmpeg -i input_file.extension -ss 00:01:23 -to 00:02:34 -c copy output_file.extension  # ~https://unix.stackexchange.com/a/302469/447876 , https://stackoverflow.com/a/42827058/15493760
ffmpeg -i input_file.mp3 -f segment -segment_time 900 -c copy output_file%03d.mp3       # split into 15 minute files ~https://unix.stackexchange.com/a/283547/447876

lame --scale <scale you want to increase> <infile> <outfile> # increase mp3 volume
sudo apt-get install easytag # audio file metadata manipulation tool
mp3info -p "%m" file.mp3 # length in minutes

# cleanup # clean up
sudo apt-get clean
sudo du -ah --max-depth=100 / | sort -hr | head -n 20
docker system prune