-- whileѭ�����
local a=1;
local b=10;
while a<b do
print(a);
a=a+1;
end

print('----------------');

-- repeatѭ�����
local c=1;
local d=10;
repeat
	print(c);
	c=c+1;
until c==d

print('-------------------');

-- ������ʽ��forѭ��
local sum=0;
for i=1,100,1 do
sum=sum+i;
end
print(sum);
