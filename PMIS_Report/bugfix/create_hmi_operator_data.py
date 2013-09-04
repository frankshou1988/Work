fp=open("OperatedByID.txt")
for line in fp:
	line=line.strip()
	if len(line) > 0:
		items=line.split("\t")
		oid=items[0]
		oname=items[1]
		print "INSERT INTO [hmi_operator] ([plc_id],[operator_name],[plc_structure_type] ) VALUES ("+oid+",'"+oname+"','TPM6')"
fp.close()
