# Named "z-load-extensions.sh" because postgres docker runs these scripts in alphabetical order,
# and it needs to run after supabase's other scripts have run.

createdb --username="$POSTGRES_USER" "user_transactions"

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" -d user_transactions <<EOF
CREATE EXTENSION supabase_vault CASCADE;
select * FROM pg_extension;
EOF
