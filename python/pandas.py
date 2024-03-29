import pandas as pd
import numpy as np
import csv

'''
Create two equivalent DataFrames with structure:
  col_1 col_2 col_3
0     a     b     c
1     d     e     f
2     g     h     i
'''
def create_df():
    df1 = pd.DataFrame({'col_1': ['a', 'd', 'g'], 'col_2': ['b', 'e', 'h'], 'col_3': ['c', 'f', 'i']},
                       index=['0', '1', '2'])
    df2 = pd.DataFrame(np.array([['a', 'b', 'c'], ['d', 'e', 'f'], ['g', 'h', 'i']]),
                       columns=['col_1', 'col_2', 'col_3'])

df = pd.read_csv('in.csv', error_bad_lines=False, usecols=['foo', 'bar'], nrows=10, header=None, index_col=0) # nrows (optional parameter) - Number of rows of file to read. Useful for reading pieces of large files.
df.to_csv('out.txt', index=False, header=False, quoting=csv.QUOTE_NONE)

df = df.resample('1M').sum()

df.index = pd.to_datetime(df.index)
df.columns = ['new_col_name_1', 'new_col_name_2'] # renaming column names

df.shape
df.head(1) # Return the first n rows. # df.head() - Viewing the first 5 lines # ~https://pandas.pydata.org/pandas-docs/stable/reference/api/pandas.DataFrame.head.html
df.tail(1)
df.sample() # Random rows

df['col1'] = df['col1'].str.replace(',', '-')
df['col1'] = df['col1'].str.slice(0, 9)
df['col1'] = df['col1'].str[-1].unique() # last character from each row of col1 -> unique
df["col1"].nunique() # number of unique values
df["col1"].value_counts() # df["col1"].value_counts(normalize=True) → % occurrence of specific values
df['col1'] = 'my_prefix' + df['col1'].astype(str)
df['col1'] = df['col1'].fillna(value='replacement value for NaN')
df = df.fillna(value='replacement value for NaN')
df['col1'].fillna(df['col2'], inplace=True) # replace the NaN in column 'col1' with the value from column 'col2'

df = df[(df['col1'] == 'val1') & (df['col2'] == 123)]
df = df[df['col1'] != 123]
df = df[df.col1 > 100] # only rows where col greater than 100
df = df[df['col1'].isin(['expected_cell_value1', 'expected_cell_value2', 'expected_cell_value3'])]

df['col7'] = df.iloc[:, 0: 6].sum(axis=1)       # sum columns (from 0th to 6th column)
df['col8'] = df[['col1', 'col4']].sum(axis=1)   # sum columns ('col1' and 'col4')

df = df.drop('1', axis=0)       # delete row '1'
df = df.drop('col_1', axis=1)   # delete column 'col_1'

df.rolling(window=30).mean() # Simple Moving Average, 30-days window
df.ewm(span=30).mean() # Exponentially Weighted Moving Average
