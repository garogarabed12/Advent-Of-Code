# Part 1


input_file = open("input.txt", "r")
instructions = input_file.read().split("\n")
input_file.close()

horizontal_position = 0
vertical_position = 0
for line in instructions:
    command = line.split(" ")
    if command[0] == 'forward':
        horizontal_position += int(command[1])
    elif command[0] == 'down':
        vertical_position += int(command[1])
    elif command[0] == 'up':
        vertical_position -= int(command[1])

print("Answer for part 1: %2d" % (horizontal_position * vertical_position))

# Part 2


horizontal_position = 0
vertical_position = 0

aim = 0

for line in instructions:
    command = line.split(" ")
    if command[0] == 'forward':
        horizontal_position += int(command[1])
        vertical_position += aim * int(command[1])
    elif command[0] == 'down':
        aim += int(int(command[1]))
    elif command[0] == 'up':
        aim -= int(int(command[1]))

print("Answer for part 2: %2d" % (horizontal_position * vertical_position))
