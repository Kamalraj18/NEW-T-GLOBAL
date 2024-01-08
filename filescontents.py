import glob

myfile = glob.glob("files/*.txt")

for filepath in myfile:
    with open(filepath, 'r') as file:
        print(file.readlines())


