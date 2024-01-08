def find_average():
    with open('average.txt', 'r') as file:
        data = file.readlines()
        avg_data = data[1:]
        avg_data1 = [float(i) for i in avg_data]
        avgg=sum(avg_data1)/len(avg_data1)
    return avgg

print(find_average())


