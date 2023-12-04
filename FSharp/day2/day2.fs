open System.IO

let lines = File.ReadAllText "./day2/input.txt"


let input:string[] = lines.Split("\r\n")

// Part 1

type Move = Rock | Paper | Scissors
type Result = Win | Lose | Draw

let evaluateEachPlayer(play:string) = 
        match play with
        | "X" | "A" -> Rock
        | "Y" | "B" -> Paper
        | "Z" | "C" -> Scissors        

let scorePerMove(move:Move) =
    match move with
    | Rock -> 1
    | Paper -> 2
    | Scissors -> 3

let scorePerResult(result:Result) =
    match result with
    | Lose -> 0
    | Draw -> 3
    | Win -> 6

let evaluatePlay(line:Move[]) = 
    match line[0], line[1] with
    | Rock, Scissors -> scorePerMove(line[1]) + scorePerResult(Lose)
    | Rock, Paper -> scorePerMove(line[1]) + scorePerResult(Win)
    | Paper, Rock -> scorePerMove(line[1]) + scorePerResult(Lose)
    | Paper, Scissors -> scorePerMove(line[1]) + scorePerResult(Win)
    | Scissors, Rock -> scorePerMove(line[1]) + scorePerResult(Win)
    | Scissors, Paper -> scorePerMove(line[1]) + scorePerResult(Lose)
    | _ -> scorePerMove(line[1]) + scorePerResult(Draw)


let splitted = input |> Array.map(fun x-> x.Split(" "))

let evaluatePlays =
    [for play in splitted do play |> Array.map (fun x -> evaluateEachPlayer(x)) |> evaluatePlay]

let resPart1 = evaluatePlays |> Seq.sum

// Part 2

type Decision = Rock | Paper | Scissors | Win | Lose | Draw

let scorePerMove2(decision:Decision) =
    match decision with
    | Lose -> 0
    | Rock -> 1
    | Paper -> 2
    | Scissors | Draw -> 3
    | Win -> 6

let evaluateEachPlayer2(play:string) = 
        match play with
        | "A" -> Rock
        | "B" -> Paper
        | "C" -> Scissors
        | "X" -> Lose
        | "Y" -> Draw
        | "Z" -> Win

let evaluatePlay2(line:Decision[]) = 
    match line[0], line[1] with
    | Rock, Draw -> scorePerMove2(Rock) + scorePerMove2(Draw)
    | Paper, Draw -> scorePerMove2(Paper) + scorePerMove2(Draw)
    | Scissors, Draw -> scorePerMove2(Scissors) + scorePerMove2(Draw)
    | Rock, Win -> scorePerMove2(Paper) + scorePerMove2(Win)
    | Paper, Win -> scorePerMove2(Scissors) + scorePerMove2(Win)
    | Scissors, Win -> scorePerMove2(Rock) + scorePerMove2(Win)
    | Rock, Lose -> scorePerMove2(Scissors) + scorePerMove2(Lose)
    | Paper, Lose -> scorePerMove2(Rock) + scorePerMove2(Lose)
    | Scissors, Lose -> scorePerMove2(Paper) + scorePerMove2(Lose)


let evaluatePlays2 =
    [for play in splitted do play |> Array.map (fun x -> evaluateEachPlayer2(x)) |> evaluatePlay2]

let resPart2 = evaluatePlays2 |> Seq.sum