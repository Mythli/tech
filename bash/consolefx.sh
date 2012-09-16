CFXUnderline=$(tput sgr 0 1)
CFXBold=$(tput bold)
CFXRed=${CFXBold}$(tput setaf 1)
CFXBlue=${CFXBold}$(tput setaf 4)
CFXWhite=${CFXBold}$(tput setaf 7)
CFXGreen=${CFXBold}$(tput setaf 2)
CFXDefault=$(tput sgr0)
CFXFeedback=${CFXWhite}*${CFXDefault}
CFXPassword=${CFXBlue}*${CFXDefault}
CFXWarning=${bldred}*${CFXDefault}
CFXQuestion=${CFXBlue}?${CFXDefault}


echo -e "${CFXUnderline} CFXUnderline${CFXDefault}"
echo -e "${CFXBold} CFXBold${CFXBold}"
echo -e "${CFXUnderline} CFXUnderline${CFXDefault}"
echo -e "${CFXRed} CFXRed${CFXDefault}"
echo -e "${CFXBold} CFXBold${CFXDefault}}"
echo -e "${CFXBlue} CFXBlue${CFXDefault}"
echo -e "${CFXWhite} CFXWhite${CFXDefault}"
echo -e "${CFXGreen} CFXGreen${CFXDefault}"
echo -e "${CFXBlue} CFXBlue${CFXDefault}"
echo -e "${CFXDefault} CFXDefault"
echo -e "${CFXFeedback} CFXFeedback${CFXDefault}"
echo -e "${CFXPassword} CFXPassword${CFXDefault}"
echo -e "${CFXWarning} CFXWarning${CFXDefault}"
echo -e "${CFXQuestion} CFXQuestion${CFXDefault}"