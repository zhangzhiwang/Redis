-- ����
--function (i)
--	return i+1;
--end

-- ��������ֵ��һ���ֲ�����
local a=function (i)
	return i+1;
end

-- �����򻯶��巽ʽ
local function b(i)
	return i+1;
end
--[[Ч����ͬ�ڣ�
local b=function (i)
	return i+1;
end
]]

-- ʵ�θ��������βθ���
local function c (i)
	print(i);
	return i+1;
end
c(1,2); -- ���ú���c

print('--------------------');

-- ʵ�θ��������βθ���
local function d(i,j)
	print(i);
	print(j);
end
d(1);

print('---------------------');

-- �ɱ����
local function e(i,j,...)
	print(i);
	print(j);
	local args={...};
	print(#args);
	return unpack(args);
end
e(1,2,3,4);
print(e(1,2,3,4));

print('--------------');

-- unpack����
local function f(...)
	local args={...};
	return unpack(args);
end
print(f(1,2,3));
