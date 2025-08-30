-- Select p.product_id, u.units, p.price
-- From UnitsSold u
-- Join Prices p
--     Where u.product_id = p.product_id
--     And u.purchase_date Between p.start_date And p.end_date;

-- Select p.product_id, u.units * p.price As total_price
-- From UnitsSold u
-- Join Prices p
--     Where u.product_id = p.product_id
--     And u.purchase_date Between p.start_date And p.end_date;

Select p.product_id,
       Round(
            Coalesce(
                Sum(u.units * p.price)/ NullIf(Sum(u.units),0),
            0),
        2) As average_price
From Prices p
Left Join UnitsSold u
    On u.product_id = p.product_id
    And u.purchase_date Between p.start_date And p.end_date
Group By p.product_id;