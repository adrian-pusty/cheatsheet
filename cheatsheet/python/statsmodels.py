from statsmodels.tsa.seasonal import seasonal_decompose

# df = ...
df = seasonal_decompose(df['Close'], period = 90)
