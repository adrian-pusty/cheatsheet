# Documents
mutool convert -o output_file.txt input_file.epub # https://mupdf.com/

## PDF
pdftk input_file.pdf cat 111-222 output output_file.pdf # Extract pages 111-222 from input_file.pdf to output_file.pdf

pdftk input_1.pdf input_2.pdf cat output output.pdf # Merge multiple pdfs
pdfunite input_1.pdf input_2.pdf output.pdf # Merge multiple pdfs # worked a bit faster than pdftk (see above) for me

# Audio / Video
ffmpeg -i input_file.extension -ss 00:01:23 -to 00:02:34 -c copy output_file.extension # ~https://unix.stackexchange.com/a/302469/447876 , https://stackoverflow.com/a/42827058/15493760