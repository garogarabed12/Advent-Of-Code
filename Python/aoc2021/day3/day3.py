# Part 1


input_file = open("input.txt", "r")
diagnostic_report = input_file.read().split("\n")
input_file.close()


def count_zeros_and_ones(index, lines):
    zeros_counter, ones_counter = 0, 0
    n_th_digits = [line[index - 1:index] for line in lines]
    for digit in n_th_digits:
        if digit == '0':
            zeros_counter += 1
        elif digit == '1':
            ones_counter += 1
    return zeros_counter, ones_counter


def calculate_common_bit(index, lines, parameter):
    zeros_counter, ones_counter = count_zeros_and_ones(index, lines)
    if parameter == 'gamma' or parameter == 'oxygen generator':
        if zeros_counter > ones_counter:
            return '0'
        else:
            return '1'
    elif parameter == 'epsilon' or parameter == 'CO2 scrubber':
        if zeros_counter > ones_counter:
            return '1'
        else:
            return '0'


def calculate_the_rates():
    gamma_string, epsilon_string = '', ''
    for i in range(1, len(diagnostic_report[1]) + 1):
        gamma_string += str(calculate_common_bit(i, diagnostic_report, 'gamma'))
        epsilon_string += str(calculate_common_bit(i, diagnostic_report, 'epsilon'))
    return int(gamma_string, 2), int(epsilon_string, 2)


gamma_rate, epsilon_rate = calculate_the_rates()

print("Answer for part 1: %2d" % (gamma_rate * epsilon_rate))


# Part 2

def calculate_a_rating(rating_type):
    most_common_bit = calculate_common_bit(1, diagnostic_report, rating_type)
    filtered_diagnostic_report = [line for line in diagnostic_report if line[0:1] == str(most_common_bit)]
    for i in range(2, 13):
        most_common_bit = calculate_common_bit(i, filtered_diagnostic_report, rating_type)
        for line in filtered_diagnostic_report[:]:
            if str(line[i - 1:i]) != str(most_common_bit):
                filtered_diagnostic_report.remove(line)
        if len(filtered_diagnostic_report) == 1:
            break
    return int(filtered_diagnostic_report[0], 2)


oxygen_generator = calculate_a_rating('oxygen generator')
co2_scrubber = calculate_a_rating('CO2 scrubber')
print("Answer for part 2: %2d" % (oxygen_generator * co2_scrubber))
