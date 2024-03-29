open System.IO
open Microsoft.FSharp.Core
open System.Collections.Generic
open Microsoft.FSharp.Collections

let lines = File.ReadAllText "./day3/input.txt"
let input: string [] = lines.Split("\r\n")

let items = [ 'a' .. 'z' ] @ [ 'A' .. 'Z' ]
let priorityValues = [ 1..52 ]

let priorities = List.zip items priorityValues

let getValue [ itemType ] =
    match priorities
          |> List.tryFind (fun (k, v) -> k = itemType)
        with
    | Some (k, v) -> v
    | None -> failwith "Key not found" // generated by chatGPT

let splitRucksack (rucksack: string) =
    let compartment1 = rucksack.Substring(0, rucksack.Length / 2)
    let compartment2 = rucksack.Substring(rucksack.Length / 2)
    [| compartment1; compartment2 |]

let getCommonCharacter (splittedTuple: string []) =
    let list1 = splittedTuple[0] |> Seq.toList
    let list2 = splittedTuple[1] |> Seq.toList

    Set.intersect (Set.ofList list1) (Set.ofList list2)
    |> Set.toList

// Part 1:
let buggyInput = input |> Array.filter (fun x -> x.Length % 2 <> 0)

let resultPart1 =
    input
    |> Array.map (fun rucksack -> splitRucksack (rucksack))
    |> Array.map (fun compartments -> getCommonCharacter (compartments))
    |> Array.map (fun x -> getValue (x))
    |> Array.sum

resultPart1 |> printfn "%d"

// Part 2
let commonCharInGroup (group: string list) =
    let set1 = group[0] |> Set.ofSeq
    let set2 = group[1] |> Set.ofSeq
    let set3 = group[2] |> Set.ofSeq

    set1
    |> Set.intersect set2
    |> Set.intersect set3
    |> Set.toList


let resultPart2 =
    input
    |> Array.chunkBySize 3
    |> Array.map (fun x -> Seq.toList x)
    |> Array.map (fun x -> commonCharInGroup (x))
    |> Array.map (fun x -> getValue (x))
    |> Array.sum

resultPart2 |> printfn "%d"
