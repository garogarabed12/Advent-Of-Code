# Part 1

input_file = open("input.txt", "r")
data = input_file.read().split("\n")
input_file.close()

counter = 0

for i in range(1, len(data)):
    if int(data[i]) > int(data[i - 1]):
        counter = counter + 1

print("Answer for part 1: %2d" % counter)


# Part 2

def count_three_measurement_window(index):
    return sum(int(data[index]) for index in (index, index + 2))


counter = 0
for i in range(0, len(data) - 2):
    if count_three_measurement_window(i) > count_three_measurement_window(i - 1):
        counter = counter + 1

print("Answer for part 2: %2d" % counter)
