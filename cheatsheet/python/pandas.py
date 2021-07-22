import pandas as pd
import csv

df = pd.read_csv('in.csv', error_bad_lines=False)
df.to_csv('out.txt', index=False, header=False, quoting=csv.QUOTE_NONE)

df.columns = ['new_col_name_1', 'new_col_name_2'] # renaming column names

df['col1'] = df['col1'].str.replace(',', '-')
df['col1'] = df['col1'].str.slice(0, 9)
df['col1'] = df['col1'].str[-1].unique() # last character from each row of col1 -> unique
df['col1'] = 'my_prefix' + df['col1'].astype(str)

df = df[(df['col1'] == 'val1') & (df['col2'] == 123)]
df = df[df['col1'] != 123]
df[df.col1 > 100] # only rows where col greater than 100

df.drop('col1', axis=1)
