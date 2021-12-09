from collections import defaultdict, Counter

input_file = open("input.txt", "r")
input_dict = Counter([int(number) for number in input_file.read().split(',')])
input_file.close()


# (Github @jonathanpaulson) helped me learn a little bit more about dictionaries.
def simulate_fish_growth(puzzle_dict, number_of_days):
    for _ in range(number_of_days):
        tmp_puzzle_dict = defaultdict(int)
        for fish, fish_count in puzzle_dict.items():
            if fish == 0:
                tmp_puzzle_dict[6] += fish_count
                tmp_puzzle_dict[8] += fish_count
            else:
                tmp_puzzle_dict[fish - 1] += fish_count
        puzzle_dict = tmp_puzzle_dict
    return sum(puzzle_dict.values())


# Part 1
print(simulate_fish_growth(input_dict, 80))
# Part 1
print(simulate_fish_growth(input_dict, 256))
