-- ������
local a={}; -- ����һ���ձ���ֵ������a
a['field']='value'; --�������Ԫ�أ�����Ԫ�ص�field�ֶθ�ֵvalue
print(a.field); -- ���ʱ��е�Ԫ�ط���һ
print(a['field']); -- ���ʱ��е�Ԫ�ط����������ߵ�Ч

local person={ -- �ڶ�����ʱ�����Ԫ��
	name='zzw',
	age=27
};
print(person.age);
print(person['age']);

-- ������Ϊ����ʱ�����൱������
local b={};
b[1]='aaa';
b[2]='bbb';
print(b[1]);

local c={'Bob','John'};
print(c[1]);

print('------------------');

-- ͨ����ʽforѭ���������飨�������Ϊ������
for index,value in ipairs(c) do
	print(index);
	print(value);
end

print('--------------');

-- ������ʽforѭ����������
for i=1,#c do
	print(i);
	print(c[i]);
end

print('-----------------------');

-- ���ڷ�����ı�ı�����pairs()
local d={
	name='zzw';
	city='Beijing'
};

for i,v in pairs(d) do
	print(i);
	print(v);
end
