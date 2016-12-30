local a=10
if true then
	local a=a+1
	print(a)
	do
		local a=a+1
		print(a)
	end
	print(a)
end
print(a)