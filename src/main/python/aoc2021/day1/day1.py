# Part 1

input_file = open("input.txt", "r")
data = input_file.read().split("\n")
input_file.close()

counter = 0

for i in range(1, len(data)):
    previous = int(data[i - 1])
    current = int(data[i])
    if current > previous:
        counter = counter + 1

print(counter)

counter = 0


# Part 2

def count_three_measurement_window(index):
    return int(data[index]) + int(data[index + 1]) + int(data[index + 2])


for i in range(0, len(data) - 2):
    previous_window_sum = count_three_measurement_window(i - 1)
    current_window_sum = count_three_measurement_window(i)
    if current_window_sum > previous_window_sum:
        counter = counter + 1

print(counter)
