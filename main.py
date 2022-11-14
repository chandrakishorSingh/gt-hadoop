import csv

dataset_path = '/usr/local/hadoop-dataset.txt'
file = open(dataset_path, 'r')
file.readline()

# title : string
# authors : string
# year : string
# publication venue : string
# index : string
# references : string
# abstract : string
with open('gt-dataset.csv', 'w') as csvfile:
    writer = csv.writer(csvfile, delimiter=',', quoting=csv.QUOTE_MINIMAL)

    # set headers
    writer.writerow(['title', 'authors', 'year', 'venue', 'index', 'references', 'abstract'])

    # we already know the number of records in the dataset
    no_of_papers = 629814

    # structure of one row of dataset
    for _ in range(no_of_papers):
        row = {
            'title': '',
            'authors': '',
            'year': '',
            'venue': '',
            'index': '',
            'references': '',
            'abstract': ''
        }

        # extract the attributes from one row at a time
        while True:
            line = file.readline()
            line = line.strip()

            # write the row to csv file
            if len(line) == 0:
                writer.writerow(
                    [row['title'], row['authors'], row['year'], row['venue'], row['index'], row['references'],
                     row['abstract']])
                break

            # code contains the symbol which indicates which attribute we are handling currently
            code = line[1]

            if code == '*':
                # title
                row['title'] = line[2:]
            elif code == '@':
                # authors
                row['authors'] = line[2:]
            elif code == 't':
                # year
                row['year'] = line[2:]
            elif code == 'c':
                # venue
                row['venue'] = line[2:]
            elif code == 'i':
                # index
                row['index'] = line[1:]
            elif code == '%':
                # references
                if len(row['references']) == 0:
                    row['references'] = line[2:]
                else:
                    row['references'] += ('_' + line[2:])
            elif code == '!':
                # abstract
                row['abstract'] = line[2:]
            else:
                raise 'Error in parsing input!'
