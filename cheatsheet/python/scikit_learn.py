from sklearn.model_selection import train_test_split

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=101) # https://scikit-learn.org/stable/modules/generated/sklearn.model_selection.train_test_split.html