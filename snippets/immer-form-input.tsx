
{renderFormFieldInput({
  styleInput: { width: 200 },
  label: lang.scope,
  value: form.scope,
  showRequired: true,
  validationFailure: failures.scope,
  onChange: (value: string) => {
    console.log("edit scope", value);
  },
})}
