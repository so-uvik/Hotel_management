## Available Rooms - US001

Question: Write a unix command to retrieve the room type, and date for room availability status=Available

- Answer

```sh
awk -F'|' '$4 == "Available" {print $3, $6}' roomStatus.txt
```

- If you want the output to be structured, pipe(|) the output of the previous command to `column -t`

```sh
awk -F'|' '$4 == "Available" {print $3, $6}' roomStatus.txt | column -t
```

>[!NOTE]
>
> `column` is essentially an utility tool that formats output based on columns. The `-t` option determines the number of columns the input contains and creates a `table` out of it. Table output is useful for pretty-printing.

- Incase, jodi kopal kharap thake ar subhajit bole je, the headings should also be present in the output taholei eta hobe.

```sh
awk -F'|' 'BEGIN{print "RoomType Availability"} $4 == "Available" {print $3, $6}' roomStatus.txt | column -t
```

## Reservation Page - US002

Question: Write a unix command to count the number of Approved Reservations

- Answer

```sh
awk -F'|' '$3 == "Approved" {count++} END{print "Number of Approved reservations:" count}' reservation.txt
```

## Bookings Page - US003

Question: Write a unix command to display the below details in descending order of Upcoming Bookings date

- Answer

```sh
sort -t '|' -k5,5r bookings.txt
```

>[!NOTE]
>5,5 could also be written as 5. When you specify only 5, it means sorting from the 5th column to the last column. In contrast, 5,5 explicitly indicates sorting only by the 5th column. In this case, both will produce the same result.

- If you want the output to be structured.

```sh
sort -t '|' -k5,5r bookings.txt | column -s '|' -t
```

- If by chance the invigilator asks the output to show only three columns i.e. Booking ID, Guest name, Upcoming Bookings Date

```sh
sort -t '|' -k5,5r bookings.txt | awk -F'|' '{print $1, $2, $5}' 
```

- To format the output

```sh
sort -t '|' -k5,5r bookings.txt | awk -F'|' '{print $1"|" $2"|"$5}' | column -s '|' -t
```

## Reservation Page - US004

Question: Write a unix command to retrieve the details of the guest whose name=Sharan. If the details are not found, then print no details found.

- Answer

```sh
awk -F',' '/Sharan/ {print;found=1} END{if(found!=1) print "no details found"}' reservation2.txt
```

- In order to test the "no details found" condition remove the last two entries from the `reservation2.txt` file and run the above command again.

## Active Complaints Count - US005

Question: Write a unix command to count the number of active complaints which is provided in `Status`

- Answer

```sh
awk -F'|' '$7 == "Active" {count++} END{print "No of Active Complaints:"count}' complaints.txt
```

## Guest Bill Details - US006

Question: Write a unix command to display the average bill of all the guests present in the file

- Answer

```sh
awk -F'|' '{if(NR>1) {bill=substr($6,2); sum+=bill}} END {if(NR>1) print "Average:$" sum/(NR-1); else print "Average Bill:$" sum}' bill.txt
```

### Explanation

- `NR>1`: NR in awk means Number of Records, which represents the current line number being processed. Also acts as a global counter.
- `bill=substr($6,2)`: extracts the substring starting from the second character, eventually removing the `$` symbol from the data and storing it in the `bill` variable.
