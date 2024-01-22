INSERT INTO public.permissions
("name")
VALUES
('GET_MEASUREMENT'),
('CREATE_MEASUREMENT'),
('GET_RECIPE'),
('CREATE_RECIPE'),
('EDIT_RECIPE'),
('DELETE_RECIPE'),
('GET_PERMISSION'),
('CREATE_PERMISSION'),
('REMOVE_PERMISSION'),
('ASSIGN_PERMISSION'),
('GET_API_KEY'),
('CREATE_API_KEY'),
('REMOVE_API_KEY'),
('GET_FEATURE_FLAG'),
('CREATE_FEATURE_FLAG'),
('DELETE_FEATURE_FLAG');

INSERT INTO public.api_keys
(api_key, "type", requests)
VALUES(uuid_generate_v4(), 'ADMIN', 0);

INSERT INTO public.api_key_permissions
(apikey_id, permission_id)
values
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16);