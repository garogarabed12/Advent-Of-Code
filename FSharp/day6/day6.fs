open System
open System.IO
open System.Linq


let datastreamBuffer = File.ReadAllText "./day6/input.txt"

let firstMarkerIndex (datastreamBuffer: string) (distinctCharsSize: int) =
    let mutable myints = [ 0 ]

    for i = (distinctCharsSize - 1) to (datastreamBuffer.Length) do
        let chars = datastreamBuffer[i - (distinctCharsSize - 1) .. i]
        let uniqueChars = chars |> Seq.distinct |> Seq.toArray

        if uniqueChars.Length = distinctCharsSize then
            myints <- List.append myints [ i + 1 ]
        else
            myints <- List.append myints [ 0 ]

    myints <- myints |> List.filter (fun x -> x <> 0)
    int myints.Head


let resPart1 = firstMarkerIndex datastreamBuffer 4
let resPart2 = firstMarkerIndex datastreamBuffer 14
