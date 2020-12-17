INSERT INTO 
    vehicle_class("id", "type" ,charge_e, charge_r, created_at, updated_at)
VALUES 
    (100000, 'SMALL', '10', '2', '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
    (100001, 'MIDDLE', '15', '3', '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
    (100002, 'LUXURY', '20', '4', '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
    (100003, 'SUV', '20', '4', '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
    (100004, 'PRIME SUV', '30', '5', '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
    (100005, 'MINI VAN', '15', '3', '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
    (100006, 'WAGON', '15', '3', '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
    (100007, 'SPORTSCAR', '40', '8', '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
    (100008, 'SUPERCAR', '80', '10', '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
    (100009, 'VAN', '30', '2', '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
    (100010, 'PICKUP', '20', '2', '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
    (100011, 'LIMO', '30', '2', '2020-11-22 19:10:25', '2020-11-22 19:10:25');

INSERT INTO
    addresses("id", country, state, city, street, zipcode, created_at, updated_at)
VALUES
(100000, 'UNITED OF AMERICA', 'NY', 'Brooklyn', '21st Street', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100001, 'UNITED OF AMERICA', 'NY', 'Brooklyn', '22nd Street', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100002, 'UNITED OF AMERICA', 'NY', 'Brooklyn', '23rd Street', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100003, 'UNITED OF AMERICA', 'NY', 'Brooklyn', '24th Street', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100004, 'UNITED OF AMERICA', 'NY', 'Brooklyn', '25th Street', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100005, 'UNITED OF AMERICA', 'NY', 'Brooklyn', '26th Street', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100006, 'UNITED OF AMERICA', 'NY', 'Brooklyn', '27th Street', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100007, 'UNITED OF AMERICA', 'NY', 'Brooklyn', '28th Street', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100008, 'UNITED OF AMERICA', 'NY', 'Brooklyn', '29th Street', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100009, 'UNITED OF AMERICA', 'NY', 'Brooklyn', '20th Street', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25');

INSERT INTO
    office_location("id", ofc_street_add, ofc_city, ofc_state, ofc_zipcode, created_at, updated_at, ofc_number)
VALUES
(100000, '13th street', 'Brooklyn', 'NY', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25', 3458790034),
(100001, '14th street', 'Brooklyn', 'NY', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25', 3458790034),
(100002, '15th street', 'Brooklyn', 'NY', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25', 3458790034),
(100003, '16th street', 'Brooklyn', 'NY', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25', 3458790034),
(100004, '17th street', 'Brooklyn', 'NY', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25', 3458790034),
(100005, '18th street', 'Brooklyn', 'NY', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25', 3458790034),
(100006, '19th street', 'Brooklyn', 'NY', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25', 3458790034),
(100007, '20th street', 'Brooklyn', 'NY', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25', 3458790034),
(100008, '23th street', 'Brooklyn', 'NY', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25', 3458790034),
(100009, '26th street', 'Brooklyn', 'NY', 11223, '2020-11-22 19:10:25', '2020-11-22 19:10:25', 3458790034);


INSERT INTO
    vehicle("id", make, vin, "year", model, license_no, loc_id, type_id, created_at, updated_at)
VALUES
(100000, 'BMW', 8008208820, 2016, '325i', 'L118119', 100000, 100001, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100001, 'Benz', 8008208821, 2016, 'E class', 'L118118', 100000, 100002, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100002, 'Audi', 8008208822, 2016, 'A5', 'L118117', 100000, 100002, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100003, 'Ford', 8008208823, 2016, 'F150', 'L118116', 100002, 100010, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100004, 'Chevrolet', 8008408820, 2016, 'Suburban', 'L118115', 100000, 100004, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100005, 'Nissan', 8008208620, 2016, 'GTR R35', 'L118114', 100000, 100007, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100006, 'Toyota', 8008208720, 2016, 'Corolla', 'L118113', 100003, 100001, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100007, 'Honda', 8008208820, 2016, 'Civic', 'L118112', 100000, 100001, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100008, 'Jugar', 8008208810, 2016, 'XF', 'L118111', 100000, 100011, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100009, 'Ferrari', 8008207820, 2016, '488', 'L118110', 100000, 100008, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(100010, 'Volkswagon', 8001208820, 2016, 'Tiguan', 'L118122', 100000, 100003, '2020-11-22 19:10:25', '2020-11-22 19:10:25');

INSERT INTO 
    corporation("id", corp_name, registration_no, created_at, updated_at)
VALUES
(10, 'NYU', 123411, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(11, 'OSU', 123411, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(12, 'UCB', 123411, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(13, 'UCLA', 123411, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(14, 'UCI', 123411, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(15, 'UB', 123411, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(16, 'UIUC', 123411, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(17, 'UF', 123411, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(18, 'CMU', 123411, '2020-11-22 19:10:25', '2020-11-22 19:10:25'),
(19, 'UCD', 123411, '2020-11-22 19:10:25', '2020-11-22 19:10:25');

INSERT INTO 
    public.customer(customer_type, "id", created_at, updated_at, email, first_name, last_name, phone_no,  address_id,  "password")
VALUES 
('I', 100000, '2020-11-22 19:10:25', '2020-11-22 19:10:25', 'my@eamil.com', 'John', 'Lambo', 3245691124, 100000, 'pwdpwdpwd');

INSERT INTO 
    public.customer(customer_type, "id", created_at, updated_at, email, first_name, last_name, phone_no,  address_id,  "password")
VALUES 
('C', 100001, '2020-11-22 19:10:25', '2020-11-22 19:10:25', 'new@email.com', 'Steve', 'Empo', 3245691124, 100000, 'pwdpwdpwd');

INSERT INTO public.corporation_cust(
	employee_id, id, corporation_id)
	VALUES (100000, 100001, 11);

INSERT INTO public.individual_cust(
	driver_licence_no, insurance_company, insurance_policy_no, id)
	VALUES (123123123,'SAFEINSURE', 2321432443, 100000);


    
INSERT INTO
    invoice("id", invoice_date, amount, created_at, updated_at)
VALUES
(100000, '2020-11-22 19:10:25', 888.88, '2020-11-22 19:10:25', '2020-11-22 19:10:25');

INSERT INTO
    payment("id", pay_method, card_num, pay_date, pay_amount, invoice_id, created_at, updated_at)
VALUES
(100000, 'Debit', 100120110032, '2020-11-22 19:10:25', 888.88, 100000, '2020-11-22 19:10:25', '2020-11-22 19:10:25');

INSERT INTO
    coupons("id", discount, valid_from, valid_to, created_at, updated_at)
VALUES
(100000, 0.80, '2019-11-22 19:10:25', '2021-11-22 19:10:25', '2020-11-22 19:10:25', '2020-11-22 19:10:25');

INSERT INTO
    rental_service( customer_id, dropoff_id, pickup_id, coupon_id, invoice_id, vehicle_id, daily_limit, pickup_date, dropoff_date, start_odometer, end_odometer)
VALUES
( 100000, 100000, 100000, 100000, 100000, 100000, 30, '2020-11-22 09:10:25', '2020-11-22 19:10:25', 10, 30)


-- CREATE TABLE public.coupon_customer (
--     coupon_id bigint NOT NULL,
--     customer_id bigint,
--     coupon_type character varying(31) COLLATE pg_catalog."default" NOT NULL,
--     CONSTRAINT coupon_customer_pkey PRIMARY KEY (coupon_id),
--     CONSTRAINT fksfho45jkaffjhad8d FOREIGN KEY(coupon_id)
--         REFERENCES public.coupons (id) MATCH SIMPLE
--         ON UPDATE CASCADE
--         ON DELETE CASCADE,
--     CONSTRAINT fjsdklgh35vsdiodf9g FOREIGN KEY(customer_id)
--         REFERENCES public.customer(id) MATCH SIMPLE
--         ON UPDATE CASCADE
--         ON DELETE CASCADE
-- )
-- WITH (
--     OIDS = FALSE
-- )
-- TABLESPACE pg_default;
--
-- ALTER TABLE public.coupon_customer
--     OWNER to cars;
