create index IX_D5E56E50 on pr_Product (companyId);
create index IX_4172DACC on pr_Product (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1F4BA44E on pr_Product (uuid_[$COLUMN_LENGTH:75$], groupId);