#define BOOST_TEST_MODULE ModelTests

//#include <boost/test/unit_test.hpp> // static or dynamic boost build
#include <boost/test/included/unit_test.hpp> // header only boost

#define APPROVALS_BOOSTTEST
#include "ApprovalTests.hpp"

using namespace ApprovalTests;

// This puts "received" and "approved" files in approval_tests/ sub-directory,
// keeping the test source directory tidy:
auto directoryDisposer = Approvals::useApprovalsSubdirectory("approval_files");