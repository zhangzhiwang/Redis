-- lua��׼��
-- string��
local a="hello";
print(string.len(a));-- ���ߵ�Ч
print(a:len());
print(#a);

print(string.lower('AbCd'));
print(string.upper('AbCd'));

print(string.sub('world',1));
print(string.sub('world',1,#'world'));
print(string.sub('world',1,-1));
print(string.sub('world',-5));
print(string.sub('world',-5,-1));
print(string.sub('world',3,4));

print('--------------------');

-- table��
-- ������ת��Ϊ�ַ���
local b={1,2,3,4,5};
print(table.concat(b,'|'));
print(table.concat(b,'%',2,4));

-- ���������Ԫ��
local c={1,2,3};
table.insert(c,4)
print(unpack(c));
table.insert(c,2,5);
print(unpack(c));

-- ������ɾ��Ԫ��
local d={1,2,3};
table.remove(d);
print(unpack(d));
table.remove(d,1);
print(unpack(d));

print('--------------------');

--Math��
print(math.abs(1));
print(math.abs(-1));
print(math.abs('1')); -- ���Խ��ַ���ת��Ϊ����
print('--------------------');
print(math.ceil(1.2));
print(math.ceil(1.9));
print(math.floor(1.2));
print(math.floor(1.9));
print('--------------------');
print(math.max(1,3,5,7,9));
print(math.min(1,3,5,7,9));
print(math.pow(2,3));
print(math.sqrt(9));
print('-------------------');
print(math.random());
print(math.random(10));
print(math.random(3,7));
print('-----------');
math.randomseed(1);
print('seed=1');
print(math.random(1,10));
print(math.random(1,10));
print(math.random(1,10));
math.randomseed(36);
print('seed=36');
print(math.random(1,10));
print(math.random(1,10));
print(math.random(1,10));
math.randomseed(1);
print('seed=1');
print(math.random(1,10));
print(math.random(1,10));
print(math.random(1,10));
